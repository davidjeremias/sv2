package br.gov.camara.ditec.adm.sivis.util;

import java.time.LocalDate;
import java.time.Period;

public class DateInterval {

	private final LocalDate dataInicial, dataFinal;

//	public DateInterval(LocalDate dataInicial, LocalDate dataFinal) {
//		if (dataFinal == null)
//			throw new IllegalArgumentException("Data Inicial não pode ser nula.");
//
//		if (dataFinal.isBefore(dataFinal)) {
//			throw new IllegalArgumentException("Data Final tem q ser maior q data Incial.");
//		}
//
//		this.dataInicial = dataInicial;
//		this.dataFinal = dataFinal;
//
//	}
//
//	DateInterval(LocalDate dataInicial, Period period) {
//		if (dataInicial == null)
//			throw new IllegalArgumentException("The start of the range must not be null.");
//
//		if (period == null)
//			throw new IllegalArgumentException("The period must not be null.");
//
//		if (period.isNegative())
//			throw new IllegalArgumentException("The period must not be negative.");
//
//		this.dataInicial = dataInicial;
//		this.dataFinal = dataInicial.plus(period);
//	}

	public DateInterval(LocalDate dataInicial, LocalDate dataFinal) {

		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	Period period() {
		return Period.between(dataInicial, dataFinal);
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	boolean contains(LocalDate date) {
		if (date == null)
			throw new IllegalArgumentException("The date must not be null.");

		return (date.isAfter(dataInicial) || date.isEqual(dataInicial)) && date.isBefore(dataFinal);
	}

	public boolean overlapsWith(DateInterval other) {
		if (other == null)
			throw new IllegalArgumentException("The other range must not be null.");

		boolean result = true;
		if (other.getDataFinal().isBefore(other.getDataInicial()) && other.getDataFinal().isBefore(other.getDataFinal())) {
			return false;
		}
		if (other.getDataInicial().isAfter(other.getDataInicial()) && other.getDataInicial().isAfter(other.getDataFinal())) {
			return false;
		}
		return result;
	}


}
