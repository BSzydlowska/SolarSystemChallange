import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
	private final String bodyName;
	private final double orbitalPeriod;
	private final int bodyType;
	private final Set<HeavenlyBody> satellite;
	
	public static final int STAR = 1;
	public static final int PLANET = 2;
	public static final int MOON = 3;
	
	public HeavenlyBody(String bodyName, double orbitalPeriod, int bodyType) {
		super();
		this.bodyName = bodyName;
		this.orbitalPeriod = orbitalPeriod;
		this.bodyType = bodyType;
		this.satellite = new HashSet<>();
	}

	public String getBodyName() {
		return bodyName;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public boolean addMoon(HeavenlyBody moon) {
		if ((this.bodyType == 2) && (moon.getBodyType() != 3)){
			return false; 
		}
		if (this.bodyType == moon.getBodyType()){
			return false;
		}
		if ((this.bodyType!=1) && (this.bodyType != 2)){
			return false;
		}
		return this.satellite.add(moon);
	}
	
	public Set<HeavenlyBody> getSatellite() {
		return new HashSet<>(this.satellite);
	}

	public int getBodyType() {
		return bodyType;
	}
	
	
}
