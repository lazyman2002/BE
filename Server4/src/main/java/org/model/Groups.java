package org.app;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Groups {
	private Integer groupID;
	private ConcurrentHashMap<Integer, Boolean> admin;
	private String groupName;
	private ConcurrentHashMap<Schedules, Boolean> currentSchedules;
}
