package com.suptarr.database.demo.loan;

import com.suptarr.database.demo.person.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private PersonRepository personRepository;

    private LoanService loanService;

    @BeforeEach
    void setUp() {
        loanService = new LoanService(loanRepository, personRepository);
    }

    @Test
    void testGetAllLoans_ReturnsAllLoans() {
        // Arrange
        Loan loan1 = createTestLoan("LOAN001", 10000.00);
        Loan loan2 = createTestLoan("LOAN002", 25000.00);
        List<Loan> expectedLoans = Arrays.asList(loan1, loan2);

        when(loanRepository.findAll()).thenReturn(expectedLoans);

        // Act
        List<Loan> actualLoans = loanService.getAllLoans();

        // Assert
        assertThat(actualLoans).hasSize(2);
        assertThat(actualLoans).containsExactly(loan1, loan2);
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    void testGetAllLoans_ReturnsEmptyListWhenNoLoans() {
        // Arrange
        when(loanRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<Loan> actualLoans = loanService.getAllLoans();

        // Assert
        assertThat(actualLoans).isEmpty();
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    void testGetLoanByLoanId_ReturnsLoanWhenExists() {
        // Arrange
        String loanId = "LOAN001";
        Loan expectedLoan = createTestLoan(loanId, 15000.00);
        when(loanRepository.findByLoanId(loanId)).thenReturn(Optional.of(expectedLoan));

        // Act
        Optional<Loan> actualLoan = loanService.getLoanByLoanId(loanId);

        // Assert
        assertThat(actualLoan).isPresent();
        assertThat(actualLoan.get().getLoanId()).isEqualTo(loanId);
        verify(loanRepository, times(1)).findByLoanId(loanId);
    }

    @Test
    void testGetLoanByLoanId_ReturnsEmptyWhenNotExists() {
        // Arrange
        String loanId = "NONEXISTENT";
        when(loanRepository.findByLoanId(loanId)).thenReturn(Optional.empty());

        // Act
        Optional<Loan> actualLoan = loanService.getLoanByLoanId(loanId);

        // Assert
        assertThat(actualLoan).isEmpty();
        verify(loanRepository, times(1)).findByLoanId(loanId);
    }

    @Test
    void testGetLoansByPersonId_ReturnsLoansWhenPersonExists() {
        // Arrange
        Long personId = 1L;
        Loan loan1 = createTestLoan("LOAN001", 10000.00);
        Loan loan2 = createTestLoan("LOAN002", 20000.00);
        List<Loan> expectedLoans = Arrays.asList(loan1, loan2);

        when(personRepository.existsById(personId)).thenReturn(true);
        when(loanRepository.findByPersonId(personId)).thenReturn(expectedLoans);

        // Act
        List<Loan> actualLoans = loanService.getLoansByPersonId(personId);

        // Assert
        assertThat(actualLoans).hasSize(2);
        assertThat(actualLoans).containsExactly(loan1, loan2);
        verify(personRepository, times(1)).existsById(personId);
        verify(loanRepository, times(1)).findByPersonId(personId);
    }

    @Test
    void testGetLoansByPersonId_ReturnsEmptyListWhenPersonExistsButHasNoLoans() {
        // Arrange
        Long personId = 1L;
        when(personRepository.existsById(personId)).thenReturn(true);
        when(loanRepository.findByPersonId(personId)).thenReturn(Collections.emptyList());

        // Act
        List<Loan> actualLoans = loanService.getLoansByPersonId(personId);

        // Assert
        assertThat(actualLoans).isEmpty();
        verify(personRepository, times(1)).existsById(personId);
        verify(loanRepository, times(1)).findByPersonId(personId);
    }

    @Test
    void testGetLoansByPersonId_ThrowsExceptionWhenPersonNotExists() {
        // Arrange
        Long personId = 999L;
        when(personRepository.existsById(personId)).thenReturn(false);

        // Act & Assert
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> loanService.getLoansByPersonId(personId))
                .withMessage("Person not found with id: " + personId);

        verify(personRepository, times(1)).existsById(personId);
        verify(loanRepository, times(0)).findByPersonId(personId); // Should not be called
    }

    @Test
    void testGetLoansByPersonId_ThrowsExceptionWithNullPersonId() {
        // Arrange
        Long personId = null;
        when(personRepository.existsById(personId)).thenReturn(false);

        // Act & Assert
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> loanService.getLoansByPersonId(personId))
                .withMessage("Person not found with id: " + personId);

        verify(personRepository, times(1)).existsById(personId);
        verify(loanRepository, times(0)).findByPersonId(personId);
    }

    private Loan createTestLoan(String loanId, double loanAmount) {
        Loan loan = new Loan();
        loan.setLoanId(loanId);
        loan.setLoanAmount(loanAmount);
        return loan;
    }
}
