package mum.edu.project.asd;

public class NumberCell extends Content{
	
	
	private float num;
	
	public Boolean isNumber() {
		return true;
	}
	
	public  NumberCell(float num) {
		this.num = num;
	}
	
	@Override
	public String value() {
		
		return Float.toString(num);
	}

	@Override
	public String formula() {
		
		return Float.toString(num);
	}

	@Override
	public float data() {
		
		return num;
	}

}
