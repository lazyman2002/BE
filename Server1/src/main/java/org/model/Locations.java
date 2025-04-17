package org.model;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Locations {
	private Integer locationID;
	private String locationName;

	public Locations() {}

	public Integer getLocationID() {
		return locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Locations)) return false;
		Locations locations = (Locations) o;
		return Objects.equals(locationID, locations.locationID) && Objects.equals(locationName, locations.locationName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationID, locationName);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Locations{");
		sb.append("locationID=").append(locationID);
		sb.append(", locationName='").append(locationName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
