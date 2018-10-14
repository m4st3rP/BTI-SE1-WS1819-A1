package service;

public class DistanceClassificator implements IDistanceClassificator{

	@Override
	public DistanceClasses determineDistanceClass(char mode, int distance) {
		DistanceClasses dc = null;
		mode = Character.toLowerCase(mode);
		if(mode == 'a') {
			dc = determineForModeA(distance);
		}else if(mode == 'b') {
			dc = determineForModeB(distance);
		}else {
			throw new IllegalArgumentException();
		}
		return dc;
	}
	
	private DistanceClasses determineForModeA(int distance) {
		if(distance < 0) {
			throw new IllegalArgumentException();
		}
		
		DistanceClasses dc = null;
		if(distance < 8) {
			dc = DistanceClasses.CLOSE;
		}else if(8 <= distance && distance < 18){
			dc = DistanceClasses.MIDDLE;
		}else if(18 <= distance && distance < 25 ) {
			dc = DistanceClasses.FAR;
		}else {
			dc = DistanceClasses.OFF;
		}
		return dc;
	}
	
	private DistanceClasses determineForModeB(int distance) {
		if(distance < 0) {
			throw new IllegalArgumentException();
		}
		
		DistanceClasses dc = null;
		if(distance <= 5) {
			dc = DistanceClasses.CLOSE;
		}else if(5 < distance && distance < 10){
			dc = DistanceClasses.MIDDLE;
		}else if(10 <= distance && distance < 14 ) {
			dc = DistanceClasses.FAR;
		}else {
			dc = DistanceClasses.OFF;
		}
		return dc;
	}

}
