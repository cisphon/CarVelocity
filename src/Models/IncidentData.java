package Models;

public class IncidentData {
	  public final double GRAVITY = 9.80665;
	  public final double RADIUS_OF_EARTH = 6731009;

	  public Weather weather;

	  public RoadType roadType;

	  public int incidentCase;

	  public double altitude;

	  public double mph;

	  public double skidTime;

	  public double yawTime;

	  public double airborneTime;

	  public double finalVelocity;

	  public double skidDistance;

	  public double radius;

	  public double superElevation;

	  public double horizontalDistance;

	  public double verticalDistance;
	    
	  public double hypotenuseDistance;
	    

	  public void setRoadType(int caseNum) {
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



