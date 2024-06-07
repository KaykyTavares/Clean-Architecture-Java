package br.com.course.useCase;

import br.com.course.core.exception.InternalServerErrorException;
import br.com.course.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException;
}
