package start.database.shelf;

public class ShelfTests {
	
	//Workload in decigram >> Max 10Tones == 100.000.000 decigram
	protected int workload = 0; 

	
	protected boolean testWeight(int newLoad) {
		if (this.workload + newLoad > 100000000) {
			return false;
		}
		return true;
	}
	
	protected void addLoad(int newLoad) {
		this.workload += newLoad;
	}

}
