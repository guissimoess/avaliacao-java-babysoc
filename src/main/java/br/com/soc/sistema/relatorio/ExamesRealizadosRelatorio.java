package br.com.soc.sistema.relatorio;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExamesRealizadosRelatorio {
	
	private static final String ARQUIVO_RELATORIO = "C:\\Users\\pichau\\Documents\\avaliacaodev\\relatorios\\relatorio.xls";
	
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Relatório de Exames Realizados");
	
	public void gerarRelatorioExames (List<ExameRealizadoVo> examesRealizados) {
		int rownum = 0;
		
        Row headerRow = sheet.createRow(rownum++);
        int headerCellNum = 0;
        headerRow.createCell(headerCellNum++).setCellValue("ID Funcionário");
        headerRow.createCell(headerCellNum++).setCellValue("Nome Funcionário");
        headerRow.createCell(headerCellNum++).setCellValue("ID Exame");
        headerRow.createCell(headerCellNum++).setCellValue("Nome Exame");
        headerRow.createCell(headerCellNum++).setCellValue("Data Exame");
		
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        HSSFDataFormat dateFormat = workbook.createDataFormat();
        dateCellStyle.setDataFormat(dateFormat.getFormat("dd/mm/yyyy"));
        
		for (ExameRealizadoVo examesRealizado : examesRealizados) {
			Row row = sheet.createRow(rownum++);
			int cellNum = 0;
			Cell cellIdFuncionario = row.createCell(cellNum++);
			cellIdFuncionario.setCellValue(examesRealizado.getFuncionarioVo().getRowid());
			Cell cellNomeFuncionario = row.createCell(cellNum++);
			cellNomeFuncionario.setCellValue(examesRealizado.getFuncionarioVo().getNome());
			Cell cellIdExame = row.createCell(cellNum++);
			cellIdExame.setCellValue(examesRealizado.getExameVo().getRowid());
			Cell cellNomeExame = row.createCell(cellNum++);
			cellNomeExame.setCellValue(examesRealizado.getExameVo().getNome());
            Cell cellDataExame = row.createCell(cellNum++);
            cellDataExame.setCellValue(examesRealizado.getDataExame());
            cellDataExame.setCellStyle(dateCellStyle);
		}
		
		try {
			FileOutputStream out = new FileOutputStream(new File(ARQUIVO_RELATORIO));
			workbook.write(out);
			System.out.println("Relatório gerado");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
