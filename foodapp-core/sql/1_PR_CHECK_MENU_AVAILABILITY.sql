DROP PROCEDURE IF EXISTS pr_check_menu_availability;

DELIMITER $$

CREATE PROCEDURE pr_check_menu_availability(IN in_name VARCHAR(20), OUT out_status VARCHAR(20))
BEGIN
 SET out_status='Not Available';
 IF EXISTS(SELECT 1 FROM menu WHERE NAME=in_name)
 THEN 
  SET out_status='Available';
 END IF;
 END $$
 
 DELIMITER;
 
 CALL pr_check_menu_availability('Idli',@status);
 
 SELECT @status;