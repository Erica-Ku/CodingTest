SELECT APNT_NO, PT_NAME, C.PT_NO, C.MCDP_CD, DR_NAME, APNT_YMD
FROM PATIENT A JOIN DOCTOR B JOIN APPOINTMENT C
ON C.MDDR_ID = B.DR_ID
ON C.PT_NO = A.PT_NO
WHERE C.APNT_YMD LIKE '2022-04-13%'
AND C.APNT_CNCL_YN = 'N'
AND C.MCDP_CD = 'CS'
ORDER BY APNT_YMD ASC;
