package br.com.southsystem.SincronizacaoReceita;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.com.southsystem.SincronizacaoReceita.service.ExtratoCSV;
import br.com.southsystem.SincronizacaoReceita.service.ReceitaService;

@SpringBootApplication
public class SincronizacaoReceitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SincronizacaoReceitaApplication.class, args);

		String fileName = args[0];

		lerArquivoCSV(fileName);
	}

	private static void lerArquivoCSV(String fileName) {
		
		try {
			// String fileName = "src/extrato.csv";
			System.out.println("Lendo arquivo " + fileName);
			SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
			Date data = new Date();
			String dataFormatada  = formataData.format(data);
			Reader reader = Files.newBufferedReader(Paths.get(fileName));
			
			CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();

			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
			
			List<ExtratoCSV> movimentos = new ArrayList<>();
			String resultado = "Processado com sucesso em " + dataFormatada;
			
			List<String[]> movimentosCVS = csvReader.readAll();
			for (String[] movimento : movimentosCVS) {
				movimentos.add(new ExtratoCSV(movimento[0], movimento[1], movimento[2], movimento[3], resultado));
			}
			
			ReceitaService receitaService = new ReceitaService();
			receitaService.atualizarConta(movimentos);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
		
	}

}
