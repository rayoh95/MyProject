USE ODW;

CREATE TABLE ODW_MEMBER (
	PROFILE_IMAGE 		VARCHAR(100),
    MEMBER_ID 			VARCHAR(20) PRIMARY KEY,
    MEMBER_PW 			VARCHAR(1000),
	MEMBER_GENDER 		VARCHAR(10),
	MEMBER_BIRTH_Y 		VARCHAR(20),
	MEMBER_BIRTH_M 		VARCHAR(20),
	MEMBER_BIRTH_D 		VARCHAR(20),
	HP1 				VARCHAR(20),
	HP2 				VARCHAR(20),
	HP3 				VARCHAR(20),
	SMSSTS_YN 			VARCHAR(20),
	EMAIL 				VARCHAR(20),
	EMAILSTS_YN 		VARCHAR(20),
	ZIPCODE 			VARCHAR(20),
	ROADADDRESS 		VARCHAR(500),
	NUMBERADDRESS 		VARCHAR(500),
	REMAINADDRESS 		VARCHAR(500),
	JOIN_DATE 			DATE
);

ALTER TABLE
			ODW_MEMBER
ADD
			MEMBER_HEIGHT	VARCHAR(10)
AFTER
			MEMBER_GENDER;
            
ALTER TABLE
			ODW_MEMBER
ADD
			AUTO_LOGIN		VARCHAR(20) NOT NULL DEFAULT 'NO'
AFTER
			JOIN_DATE;

SELECT
		*
FROM
		ODW_MEMBER;
        
DROP TABLE ODW_MEMBER;

