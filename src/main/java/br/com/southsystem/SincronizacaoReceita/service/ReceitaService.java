package br.com.southsystem.SincronizacaoReceita.service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Service
public class ReceitaService {
	
	public void atualizarConta(List<ExtratoCSV> extratos) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		System.out.println("Enviando movmentos para Receitas");
		Writer writer = Files.newBufferedWriter(Paths.get("movimentosProcessados.csv"));
		StatefulBeanToCsv<ExtratoCSV> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
		
		System.out.println("Salvando arquivo com resultado do processamento");
		beanToCsv.write(extratos);
		
		writer.flush();
		writer.close();
		
	}
	

}
