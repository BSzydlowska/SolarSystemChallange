import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	private static Map<String, HeavenlyBody> solarSystem = new HashMap<String, HeavenlyBody>();
	private static Set<HeavenlyBody> planets = new HashSet<>();
	private static Set<HeavenlyBody> stars = new HashSet<>();
	private static Set<HeavenlyBody> moons = new HashSet<>();
	
		
	public static void main(String[] args) {
		
		//Tworzenie i wkladanie elemenentow do mapy
		HeavenlyBody temp = new HeavenlyBody("Mercury", 88, 2);
		solarSystem.put(temp.getBodyName(), temp);
		temp = new HeavenlyBody("Wenus", 225, 2);
		solarSystem.put(temp.getBodyName(), temp);
		temp = new HeavenlyBody("Ziemia", 365, 2);
		solarSystem.put(temp.getBodyName(), temp);
		temp = new HeavenlyBody("Moon", 27, 3);
		solarSystem.put(temp.getBodyName(), temp);
		temp = new HeavenlyBody("Mars", 687, 2);
		solarSystem.put(temp.getBodyName(), temp);
		temp = new HeavenlyBody("Jowisz", 4332, 2);
		solarSystem.put(temp.getBodyName(), temp);
		temp = new HeavenlyBody("Saturn", 10759, 2);
		solarSystem.put(temp.getBodyName(), temp);
		solarSystem.put("Io", new HeavenlyBody("Io", 1.8, 3));
		solarSystem.put("Ganymedes", new HeavenlyBody("Ganymedes", 7.1, 3));
		solarSystem.put("Callisto", new HeavenlyBody("Callisto", 16.7, 3));
		solarSystem.put("Europa", new HeavenlyBody("Europa", 3.5, 3));
		solarSystem.put("Ganymedes", new HeavenlyBody("Ganymedes", 71, 3));
		solarSystem.put("Ganymedes", new HeavenlyBody("Ganymedes", 71, 2));
				
		//Rozparcelowanie cial niebieskich po setach.
		for (String tempBody : solarSystem.keySet()){
			HeavenlyBody tempPlanet = solarSystem.get(tempBody);
			if (tempPlanet.getBodyType() == 1){
				stars.add(tempPlanet);
			} else if(tempPlanet.getBodyType() == 2){
				planets.add(tempPlanet);
			} else if(tempPlanet.getBodyType() == 3){
				moons.add(tempPlanet);
			}
		}
		// segregacja ksiezycow
		HeavenlyBody tempPlanet = solarSystem.get("Jowisz");
		tempPlanet.addMoon(solarSystem.get("Io"));
		tempPlanet.addMoon(solarSystem.get("Europa"));
		tempPlanet.addMoon(solarSystem.get("Callisto"));
		tempPlanet.addMoon(solarSystem.get("Ganymedes"));
		tempPlanet = solarSystem.get("Ziemia");
		tempPlanet.addMoon(solarSystem.get("Moon"));
		tempPlanet.addMoon(new HeavenlyBody("Ganymedes", 7.1, 2));
		
		//wyswietlanie
		System.out.println("Solar System:");
		for (String s : solarSystem.keySet()){
		System.out.println("\t" + s);
		}
		System.out.println("\nPlanets: ");
		for (HeavenlyBody s : planets){
			System.out.println("\t" + s.getBodyName());
			for(HeavenlyBody t : s.getSatellite()){
				System.out.println("\t\t" + t.getBodyName() + " - " + t.getOrbitalPeriod());
			}
		}
		System.out.println("\n All moons in Solar System");
		for (HeavenlyBody moon : moons){
			System.out.println("\t" + moon.getBodyName() + " - " + moon.getOrbitalPeriod());
		}
	}
}
