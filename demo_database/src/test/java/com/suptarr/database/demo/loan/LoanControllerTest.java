package com.suptarr.database.demo.loan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suptarr.database.demo.person.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoanController.class)
class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LoanService loanService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllLoans_ReturnsAllLoans() throws Exception {
        // Arrange
        Loan loan1 = createTestLoan("LOAN001", 10000.00, 1L);
        Loan loan2 = createTestLoan("LOAN002", 25000.00, 2L);
        List<Loan> expectedLoans = Arrays.asList(loan1, loan2);

        when(loanService.getAllLoans()).thenReturn(expectedLoans);

        // Act & Assert
        mockMvc.perform(get("/loans")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].loanId").value("LOAN001"))
                .andExpect(jsonPath("$[0].loanAmount").value(10000.00))
                .andExpect(jsonPath("$[1].loanId").value("LOAN002"))
                .andExpect(jsonPath("$[1].loanAmount").value(25000.00));

        verify(loanService, times(1)).getAllLoans();
    }

    @Test
    void testGetAllLoans_ReturnsEmptyListWhenNoLoans() throws Exception {
        // Arrange
        when(loanService.getAllLoans()).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/loans")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(0));

        verify(loanService, times(1)).getAllLoans();
    }

    @Test
    void testGetLoanByLoanId_ReturnsLoanWhenExists() throws Exception {
        // Arrange
        String loanId = "LOAN001";
        Loan expectedLoan = createTestLoan(loanId, 15000.00, 1L);
        when(loanService.getLoanByLoanId(loanId)).thenReturn(Optional.of(expectedLoan));

        // Act & Assert
        mockMvc.perform(get("/loans/{loanId}", loanId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.loanId").value(loanId))
                .andExpect(jsonPath("$.loanAmount").value(15000.00));

        verify(loanService, times(1)).getLoanByLoanId(loanId);
    }

    @Test
    void testGetLoanByLoanId_ReturnsNotFoundWhenNotExists() throws Exception {
        // Arrange
        String loanId = "NONEXISTENT";
        when(loanService.getLoanByLoanId(loanId)).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(get("/loans/{loanId}", loanId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(loanService, times(1)).getLoanByLoanId(loanId);
    }

    @Test
    void testGetLoansByPersonId_ReturnsLoansWhenPersonExists() throws Exception {
        // Arrange
        Long personId = 1L;
        Loan loan1 = createTestLoan("LOAN001", 10000.00, personId);
        Loan loan2 = createTestLoan("LOAN002", 20000.00, personId);
        List<Loan> expectedLoans = Arrays.asList(loan1, loan2);

        when(loanService.getLoansByPersonId(personId)).thenReturn(expectedLoans);

        // Act & Assert
        mockMvc.perform(get("/loans/persons/{personId}", personId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].loanId").value("LOAN001"))
                .andExpect(jsonPath("$[0].loanAmount").value(10000.00))
                .andExpect(jsonPath("$[1].loanId").value("LOAN002"))
                .andExpect(jsonPath("$[1].loanAmount").value(20000.00));

        verify(loanService, times(1)).getLoansByPersonId(personId);
    }

    @Test
    void testGetLoansByPersonId_ReturnsEmptyListWhenPersonExistsButHasNoLoans() throws Exception {
        // Arrange
        Long personId = 1L;
        when(loanService.getLoansByPersonId(personId)).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/loans/persons/{personId}", personId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(0));

        verify(loanService, times(1)).getLoansByPersonId(personId);
    }

    @Test
    void testGetLoansByPersonId_ReturnsNotFoundWhenPersonNotExists() throws Exception {
        // Arrange
        Long personId = 999L;
        when(loanService.getLoansByPersonId(personId))
                .thenThrow(new RuntimeException("Person not found with id: " + personId));

        // Act & Assert
        mockMvc.perform(get("/loans/persons/{personId}", personId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(loanService, times(1)).getLoansByPersonId(personId);
    }

    @Test
    void testGetLoansByPersonId_HandlesInvalidPersonIdFormat() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/loans/persons/{personId}", "invalid")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(loanService, times(0)).getLoansByPersonId(any());
    }

    private Loan createTestLoan(String loanId, double loanAmount, Long personId) {
        Loan loan = new Loan();
        loan.setLoanId(loanId);
        loan.setLoanAmount(loanAmount);

        Person person = new Person();
        person.setId(personId);
        loan.setPerson(person);

        return loan;
    }
}