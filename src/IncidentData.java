
public class IncidentData {
	  final double GRAVITY = 9.80665;
	    final double RADIUS_OF_EARTH = 6731009;

	    Weather weather;

	    RoadType roadType;

	    int incidentCase;

	    double altitude;

	    double mph;
	    
	    double skidTime;
	    
	    double yawTime;
	    
	    double airborneTime;

	    double finalVelocity;

	    double skidDistance;

	    double radius;

	    double superElevation;

	    double horizontalDistance;

	    double verticalDistance;
	    
	    double hypotenuseDistance;
	    

	    void setRoadType(int caseNum) {
	        switch (caseNum) {
	            case 1:
	                roadType = RoadType.CEMENT_NEW;
	                break;
	            case 2:
	                roadType = RoadType.CEMENT_TRAVELLED;
	                break;
	            case 3:
	                roadType = RoadType.CEMENT_POLISHED;
	                break;
	            case 4:
	                roadType = RoadType.ASPHALT_NEW;
	                break;
	            case 5:
	                roadType = RoadType.ASPHALT_TRAVELLED;
	                break;
	            case 6:
	                roadType = RoadType.ASPHALT_POLISHED;
	                break;
	            case 7:
	                roadType = RoadType.ASPHALT_EXCESS;
	                break;
	            case 8:
	                roadType = RoadType.GRAVEL_PACKED;
	                break;
	            case 9:
	                roadType = RoadType.GRAVEL_LOOSE;
	                break;
	            case 10:
	                roadType = RoadType.CINDERS_PACKED;
	                break;
	            case 11:
	                roadType = RoadType.ROCK_CRUSHED;
	                break;
	            case 12:
	                roadType = RoadType.ICE_SMOOTH;
	                break;
	            case 13:
	                roadType = RoadType.SNOW_PACKED;
	                break;
	            case 14:
	                roadType = RoadType.SNOW_LOOSE;
	                break;
	        }


	    }
	}



