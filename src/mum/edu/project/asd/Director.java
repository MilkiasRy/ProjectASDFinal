package mum.edu.project.asd;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Director
{
	private SpreadSheet spreadsheet;	

	public Director(SpreadSheet sps)
	{
	spreadsheet = sps;
	}

	public SpreadSheet getSpreadsheet() { return spreadsheet; }

	public void writeInCellText(int r, int c, String text)
	{
		if (text != null)
			spreadsheet.cell(r, c).setContent(new TextCell(text));	
	}
	
	public Cell cell(int row, int col) 							// Get a reference to cell at (row,col)
	{ 
		return spreadsheet.cell(row, col); 
	}		

	public String contents()
	{
		return spreadsheet.show();
	}

	private void writeInCellNumber(int i, int j, float f) {
		// TODO Auto-generated method stub
		
		spreadsheet.cell(i, j).setContent(new NumberCell(f));
		
	}
	// numerical expression sprint3
	public void WriteInCellExpression(int r,int c , NumericOperation obj) {
		
		//spreadsheet.cell(r, c).setContent(new NumericOperation());
	}
	
	public String describe()
	{
		return spreadsheet.describe();
	}

	public String examine()
	{
		return spreadsheet.examine();
	}
	
	public void buildSample()										// Build sample data for development purpose
	{
		writeInCellText(1, 1, "Airfare:");
		
		writeInCellNumber(1, 2, 485.15f);

		writeInCellText(1, 3, "");
		
		writeInCellText(1, 4, "What we pay to the airlines");

		writeInCellText(2, 1, "Taxi:");
		
		writeInCellNumber(2, 2, 118);

		writeInCellText(3, 1, "Rental Car:");
		
		//adding the total of rental car
		Add add = new Add();
		NumberCell num1 = new NumberCell(295);
		NumberCell num2 = new NumberCell(0.85f);
		add.addContent(num1);
		add.addContent(num2);
		
		spreadsheet.cell(3, 2).setContent(add);
		cell(3, 2).setContent(add);
		//writeInCellNumber(3, 2, add);
		

		writeInCellText(4, 1, "Hotel:");
		
		writeInCellNumber(4, 2, 431);

		writeInCellText(5, 1, "Meals:");
		
		writeInCellNumber(5, 2, 150);
		
		writeInCellText(5, 3, "");
		
		writeInCellText(5, 4, "This is all our meals");

		writeInCellText(7, 1, "Sub-total:");
		
		
		//getting the subtotal 
		Add subTotal = new Add();
		
		for (int i = 1; i <= 5; i++) {
		subTotal.addContent(new Reference(spreadsheet.cell(i, 2)));
		}
		spreadsheet.cell(7, 2).setContent(subTotal);
		cell(7, 2).setContent(subTotal);
		
		//subtracting values
		Subtract subtract = new Subtract();
		for(int i = 1 ; i <= 5 ; i++) {
			subtract.subContent(new Reference(spreadsheet.cell(i, 2)));
		}
		
		spreadsheet.cell(7, 3).setContent(subtract);
		cell(7, 3).setContent(subtract);
		
		
		//muliplying values
		Multiply multiply = new Multiply();
		for(int i = 1; i <= 5 ; i++) {
			multiply.multContent(new Reference(spreadsheet.cell(i, 2)));
		}
		
		spreadsheet.cell(7, 4).setContent(multiply);
		cell(7, 4).setContent(multiply);
		
		//writeInCellNumber(7, 2, spreadsheet.cell(1, 2).data());
		
		
		//reference goes here 
		writeInCellText(7, 5, "This is just a reference to [1, 2], to test the \"Reference\" class and mechanism");
		Reference ref = new Reference(cell(1,2));
		
		
	   //cell(7,2).setContent(ref);
	
		
		
		writeInCellText(8, 1, "Tax:");							// Tax factor label

		
		writeInCellNumber(8, 2, 0.15f);
		
		
		writeInCellText(9, 1, "Total:");
		
		//calculating total
		
		Multiply multiply2 = new Multiply();
		multiply2.multContent(new Reference(cell(7, 2)));
		multiply2.multContent(new Reference(cell(8,2))); 
		
		
		Subtract subtract2 = new Subtract();
		subtract2.subContent(new Reference(cell(7, 2)));
		subtract2.subContent(new NumberCell(multiply2.data()));
		
		spreadsheet.cell(9, 2).setContent(subtract2);
		cell(9, 2).setContent(subtract2);
		
		writeInCellText(10, 1, "Partners: ");
		
		writeInCellNumber(10, 2, 4);

		writeInCellText(11, 1, "Months: ");
		
		writeInCellNumber(11, 2, 12);
		

		writeInCellText(12, 1, "Installments:");
		Division division = new Division();
		division.divideContent(new Reference(cell(9, 2)));
		division.divideContent(new Reference(cell(10, 2)));
		division.divideContent(new Reference(cell(11, 2)));
		
		spreadsheet.cell(12, 2).setContent(division);
		cell(12, 2).setContent(division);
		

	}


}