public class Major extends Lecture {
	int majorCredit;
	//method that number of electiveCredit is 2 or 3
	public void Credit(){
		int count = 0;
		for (int i=0; i<super.period.length(); i++) {
			try{
				count += Character.getNumericValue(super.period.charAt(i));
			} catch (Exception e) {
				
			}
		}
		if (count > 2) {
			this.majorCredit = 3;
		} else {
			this.majorCredit = 2;
		}
	}
}
