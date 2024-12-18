
import com.google.protobuf.timestamp.Timestamp
import proto.Proficiency.{BEGINNER, EXPERT, INTERMEDIATE}
import proto._
import scala.util.matching.Regex
import scala.util.Try

object JsonProtoParser{
	def parseUserMetaInfo(json: String): UserMetaInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val userID = """\"userID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val username = """\"username\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("default_user")
		val password = """\"password\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("default_password")
		val isCandidate = """\"isCandidate\": (true|false)""".r.findFirstMatchIn(json).map(_.group(1).toBoolean).getOrElse(false)
		
		UserMetaInfo(userID, username, password, isCandidate)
	}
	
	def parseUserFullInfo(json: String): UserFullInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val userID = """\"userID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val username = """\"username\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val password = """\"password\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val firstname = """\"firstname\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val lastname = """\"lastname\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val email = """\"email\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val googleToken = """\"GoogleToken\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// GoogleTokenExpiration is a bit more complex as it requires parsing a Timestamp
		val googleTokenExpiration: Option[Timestamp] = """\"GoogleTokenExpiration\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						// Return the parsed Timestamp wrapped in Some
						Some(Timestamp.parseFrom(timestampStr.getBytes))
					} catch {
						case e: Exception => None
					}
				}
		
		val isCandidate = """\"isCandidate\": (true|false)""".r.findFirstMatchIn(json).map(_.group(1).toBoolean).getOrElse(false)
		
		UserFullInfo(userID, username, password, firstname, lastname, email, googleToken, googleTokenExpiration, isCandidate)
	}
	
	def parseCandidateFullInfo(json: String): CandidateFullInfo = {
		// Parse UserFullInfo as before
		val userID = """\"userID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val username = """\"username\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val password = """\"password\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val firstname = """\"firstname\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val lastname = """\"lastname\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val email = """\"email\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val googleToken = """\"GoogleToken\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse GoogleTokenExpiration (Timestamp)
		val googleTokenExpiration: Option[Timestamp] = """\"GoogleTokenExpiration\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes))
					} catch {
						case e: Exception => None
					}
				}
		
		val isCandidate = """\"isCandidate\": (true|false)""".r.findFirstMatchIn(json).map(_.group(1).toBoolean).getOrElse(false)
		
		// Create UserFullInfo object
		val user = UserFullInfo(userID, username, password, firstname, lastname, email, googleToken, googleTokenExpiration, isCandidate)
		
		// Wrap user in Some
		val userOption = Some(user)
		// Parse birthDate (Timestamp)
		val birthDate: Option[Timestamp] = """\"birthDate\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes))
					} catch {
						case e: Exception => None
					}
				}
		
		// Parse gender (enum)
		val gender = """\"gender\": (0|1)""".r.findFirstMatchIn(json).map {
			case m if m.group(1) == "0" => Gender.MALE
			case m if m.group(1) == "1" => Gender.FEMALE
		}.getOrElse(Gender.MALE) // Default to MALE if not found
		
		// Parse currentCVs (map of int32 to bool)
		val currentCVs: Map[Int, Boolean] = """\"currentCVs\": \{([^\}]+)\}""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.map { cvStr =>
					cvStr.split(",")
							.flatMap { cv =>
								val parts = cv.split(":").map(_.trim)
								if (parts.length == 2) {
									// Manually handle parsing the key (Int) and value (Boolean)
									val key = Try(parts(0).toInt).toOption
									val value = Try(parts(1).toBoolean).toOption
									for {
										k <- key
										v <- value
									} yield (k, v)
								} else {
									None
								}
							}
							.toMap
				}
				.getOrElse(Map.empty)
		
		// Create CandidateFullInfo object
		CandidateFullInfo(userOption, birthDate, gender, currentCVs)
	}
	
	def parseRecruiterFullInfo(json: String): RecruiterFullInfo = {
		// Parse UserFullInfo as before
		val userID = """\"userID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val username = """\"username\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val password = """\"password\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val firstname = """\"firstname\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val lastname = """\"lastname\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val email = """\"email\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val googleToken = """\"GoogleToken\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse GoogleTokenExpiration (Timestamp)
		val googleTokenExpiration: Option[Timestamp] = """\"GoogleTokenExpiration\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes))
					} catch {
						case e: Exception => None
					}
				}
		
		val isCandidate = """\"isCandidate\": (true|false)""".r.findFirstMatchIn(json).map(_.group(1).toBoolean).getOrElse(false)
		
		// Create UserFullInfo object
		val user = UserFullInfo(userID, username, password, firstname, lastname, email, googleToken, googleTokenExpiration, isCandidate)
		
		// Wrap user in Some (since the field is Option[UserFullInfo])
		val userOption = Some(user)
		
		// Parse companyID
		val companyID = """\"companyID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse roleID
		val roleID = """\"roleID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse departmentName
		val departmentName = """\"departmentName\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Create RecruiterFullInfo object
		RecruiterFullInfo(userOption, companyID, roleID, departmentName)
	}
	
	def parseJobRequestFullInfo(json: String): JobRequestFullInfo = {
		// Parse jobID
		val jobID = """\"jobID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse locationID
		val locationID = """\"locationID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse jobType (JobType enum)
		val jobType = """\"jobType\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt) match {
			case Some(0) => JobType.FULLTIME
			case Some(1) => JobType.HALFTIME
			case _ => JobType.FULLTIME // Default to FULLTIME if not found
		}
		
		// Parse salaryLeast
		val salaryLeast = """\"salaryLeast\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse salaryGreatest
		val salaryGreatest = """\"salaryGreatest\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse currency
		val currency = """\"currency\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse jobTitle
		val jobTitle = """\"jobTitle\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse jobLevel (JobLevel enum)
		val jobLevel = """\"jobLevel\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt) match {
			case Some(0) => JobLevel.ENTRY_LEVEL
			case Some(1) => JobLevel.MID_LEVEL
			case Some(2) => JobLevel.SENIOR_LEVEL
			case Some(3) => JobLevel.MANAGER
			case Some(4) => JobLevel.DIRECTOR
			case Some(5) => JobLevel.EXECUTIVE
			case _ => JobLevel.ENTRY_LEVEL // Default to ENTRY_LEVEL if not found
		}
		
		// Parse jobDescription
		val jobDescription = """\"jobDescription\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse deadlineDate (Timestamp)
		val deadlineDate: Option[Timestamp] = """\"deadlineDate\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes)) // Assuming the timestamp is in the correct format
					} catch {
						case e: Exception => None
					}
				}
		
		// Parse currentCVs (map[int32, bool])
		val currentCVs = """\"currentCVs\": \{([^\}]+)\}""".r.findFirstMatchIn(json)
				.flatMap { matchData =>
					val mapStr = matchData.group(1)
					// Assuming map items are formatted as "key": value
					val map = """(\d+): (true|false)""".r.findAllMatchIn(mapStr)
							.map(m => m.group(1).toInt -> m.group(2).toBoolean)
							.toMap
					Some(map)
				}
				.getOrElse(Map.empty)
		
		// Create JobRequestFullInfo object
		JobRequestFullInfo(jobID, locationID, jobType, salaryLeast, salaryGreatest, currency, jobTitle, jobLevel, jobDescription, deadlineDate, currentCVs)
	}
	
	def parseJobRequestMetaInfo(json: String): JobRequestMetaInfo = {
		// Parse jobID
		val jobID = """\"jobID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse locationID
		val locationID = """\"locationID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Create JobRequestMetaInfo object
		JobRequestMetaInfo(jobID, locationID)
	}
	
	def parseRoleFullInfo(json: String): RoleFullInfo = {
		// Parse roleID (int)
		val roleID = """\"roleID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse roleName (string)
		val roleName = """\"roleName\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse roleLevel (int)
		val roleLevel = """\"roleLevel\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse companyID (int)
		val companyID = """\"companyID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Create RoleFullInfo object
		RoleFullInfo(roleID, roleName, roleLevel, companyID)
	}
	
	def parseLocationFullInfo(json: String): LocationFullInfo = {
		// Parse locationID (int)
		val locationID = """\"locationID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse country (string)
		val country = """\"country\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse state (string)
		val state = """\"state\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse address (string)
		val address = """\"address\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse contactNumber (string)
		val contactNumber = """\"contactNumber\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse currentJobRequest (map)
		val currentJobRequest = """\"currentJobRequest\": \{([^\}]+)\}""".r.findFirstMatchIn(json) match {
			case Some(matched) =>
				val mapString = matched.group(1)
				mapString.split(",").flatMap { pair =>
					val keyValue = pair.split(":").map(_.trim)
					if (keyValue.length == 2) Some(keyValue(0).toInt -> keyValue(1).toBoolean) else None
				}.toMap
			case None => Map.empty[Int, Boolean]
		}
		
		// Parse city (string)
		val city = """\"city\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse companyID (int)
		val companyID = """\"companyID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Create LocationFullInfo object
		LocationFullInfo(locationID, country, state, address, contactNumber, currentJobRequest, city, companyID)
	}
	
	def parseLocationMetaInfo(json: String): LocationMetaInfo = {
		// Parse locationID (int)
		val locationID = """\"locationID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse contactNumber (string)
		val contactNumber = """\"contactNumber\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse companyID (int)
		val companyID = """\"companyID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Create LocationMetaInfo object
		LocationMetaInfo(locationID, contactNumber, companyID)
	}
	
	def parseCompanyFullInfo(json: String): CompanyFullInfo = {
		// Parse companiesID (int)
		val companiesID = """\"companiesID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse companyName (string)
		val companyName = """\"companyName\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse companyAvatarURL (string)
		val companyAvatarURL = """\"companyAvatarURL\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse website (string)
		val website = """\"website\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse email (string)
		val email = """\"email\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse activeRecruiters (map)
		val activeRecruiters = """\"activeRecruiters\": \{([^\}]+)\}""".r.findFirstMatchIn(json) match {
			case Some(matched) =>
				val mapString = matched.group(1)
				mapString.split(",").flatMap { pair =>
					val keyValue = pair.split(":").map(_.trim)
					if (keyValue.length == 2) Some(keyValue(0).toInt -> keyValue(1).toBoolean) else None
				}.toMap
			case None => Map.empty[Int, Boolean]
		}
		
		// Parse activeLocations (map)
		val activeLocations = """\"activeLocations\": \{([^\}]+)\}""".r.findFirstMatchIn(json) match {
			case Some(matched) =>
				val mapString = matched.group(1)
				mapString.split(",").flatMap { pair =>
					val keyValue = pair.split(":").map(_.trim)
					if (keyValue.length == 2) Some(keyValue(0).toInt -> keyValue(1).toBoolean) else None
				}.toMap
			case None => Map.empty[Int, Boolean]
		}
		
		// Create CompanyFullInfo object
		CompanyFullInfo(companiesID, companyName, companyAvatarURL, website, email, activeRecruiters, activeLocations)
	}
	
	def parseCompanyMetaInfo(json: String): CompanyMetaInfo = {
		// Parse companyID (int)
		val companyID = """\"companyID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Parse companyName (string)
		val companyName = """\"companyName\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Create CompanyMetaInfo object
		CompanyMetaInfo(companyID, companyName)
	}
	
	def parseWorkExperienceFullInfo(json: String): WorkExperienceFullInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val workExperienceID = """\"workExperienceID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val CVID = """\"CVID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val jobTitle = """\"jobTitle\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parsing startDate and endDate as google.protobuf.Timestamp
		val startDate: Option[Timestamp] = """\"startDate\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes)) // Parse the timestamp
					} catch {
						case e: Exception => None
					}
				}
		
		val endDate: Option[Timestamp] = """\"endDate\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes)) // Parse the timestamp
					} catch {
						case e: Exception => None
					}
				}
		
		val jobDescription = """\"jobDescription\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val companyName = """\"companyName\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		WorkExperienceFullInfo(workExperienceID, CVID, jobTitle, startDate, endDate, jobDescription, companyName)
	}
	
	def parseSkillFullInfo(json: String): SkillFullInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val skillID = """\"skillID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val CVID = """\"CVID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val skillName = """\"skillName\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parse the proficiency value, matching it to the enum
		val proficiencyStr = """\"proficiency\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("BEGINNER")
		val proficiency = proficiencyStr match {
			case "BEGINNER" => BEGINNER
			case "INTERMEDIATE" => INTERMEDIATE
			case "EXPERT" => EXPERT
			case _ => BEGINNER // Default to BEGINNER if not matched
		}
		
		SkillFullInfo(skillID, CVID, skillName, proficiency)
	}
	
	def parsePersonalityFullInfo(json: String): PersonalityFullInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val personalityID = """\"personalityID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val CVID = """\"CVID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val personalityTitle = """\"personalityTitle\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val description = """\"description\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		PersonalityFullInfo(personalityID, CVID, personalityTitle, description)
	}
	
	def parseEducationFullInfo(json: String): EducationFullInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val educationID = """\"educationID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val CVID = """\"CVID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val degree = """\"degree\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val field = """\"field\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val institution = """\"institution\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parsing startDate and endDate as google.protobuf.Timestamp
		val startDate: Option[Timestamp] = """\"startDate\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes)) // Parse the timestamp
					} catch {
						case e: Exception => None
					}
				}
		
		val endDate: Option[Timestamp] = """\"endDate\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes)) // Parse the timestamp
					} catch {
						case e: Exception => None
					}
				}
		
		EducationFullInfo(educationID, CVID, degree, field, institution, startDate, endDate)
	}
	
	def parseCertificationFullInfo(json: String): CertificationFullInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val certificationID = """\"certificationID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val CVID = """\"CVID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val certificationName = """\"certificationName\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val provider = """\"provider\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parsing providedDate as google.protobuf.Timestamp
		val providedDate: Option[Timestamp] = """\"providedDate\": \"([^\"]+)\"""".r.findFirstMatchIn(json)
				.map(_.group(1))
				.flatMap { timestampStr =>
					try {
						Some(Timestamp.parseFrom(timestampStr.getBytes)) // Parse the timestamp
					} catch {
						case e: Exception => None // Return None if the parsing fails
					}
				}
		
		CertificationFullInfo(certificationID, CVID, certificationName, provider, providedDate)
	}
	
	def parseCVFullInfo(json: String): CVFullInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val cvID = """\"CVID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val candidateID = """\"candidateID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val email = """\"email\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val phoneNumber = """\"phoneNumber\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val jobTitle = """\"jobTitle\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Parsing maps: map<int32, bool>
		val currentSkills = parseMap(json, "currentSkills")
		val currentPersonalities = parseMap(json, "currentPersonalities")
		val currentWorkExperiences = parseMap(json, "currentWorkExperiences")
		val currentEducations = parseMap(json, "currentEducations")
		val currentCertifications = parseMap(json, "currentCertifications")
		
		// Return the CVFullInfo object
		CVFullInfo(cvID, candidateID, email, phoneNumber, jobTitle, currentSkills, currentPersonalities, currentWorkExperiences, currentEducations, currentCertifications)
	}
	
	def parseMap(json: String, fieldName: String): Map[Int, Boolean] = {
		val mapPattern: Regex = s"""\"$fieldName\": {([^}]+)}""".r
		mapPattern.findFirstMatchIn(json).map { matchData =>
			// Extract the inner map and split by commas to get key-value pairs
			val mapContent = matchData.group(1)
			mapContent.split(",").flatMap { entry =>
				val keyValuePattern = """(\d+): (true|false)""".r
				keyValuePattern.findFirstMatchIn(entry).map { kv =>
					kv.group(1).toInt -> kv.group(2).toBoolean
				}
			}.toMap
		}.getOrElse(Map.empty)
	}
	
	def parseCVMetaInfo(json: String): CVMetaInfo = {
		// Sử dụng regex để lấy các trường từ JSON (nếu có)
		val cvID = """\"CVID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val candidateID = """\"candidateID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		
		// Return the CVMetaInfo object
		CVMetaInfo(cvID, candidateID)
	}
	
	def parseWishListFullInfo(json: String): WishListFullInfo = {
		// Extract the fields using regex
		val candidateID = """\"candidateID\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val salaryMinimum = """\"salaryMinimum\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).getOrElse(0)
		val location = """\"location\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		val insurance = """\"insurance\": \"([^\"]+)\"""".r.findFirstMatchIn(json).map(_.group(1)).getOrElse("")
		
		// Extract and parse the JobType and JobLevel enums
		val jobType = """\"jobType\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).map(JobType.fromInt).getOrElse(JobType.FULLTIME) // Default to FULLTIME
		val jobLevel = """\"jobLevel\": (\d+)""".r.findFirstMatchIn(json).map(_.group(1).toInt).map(JobLevel.fromInt).getOrElse(JobLevel.ENTRY_LEVEL) // Default to ENTRY_LEVEL
		
		// Return the parsed WishListFullInfo object
		WishListFullInfo(candidateID, salaryMinimum, location, jobType, jobLevel, insurance)
	}
}

