
DROP FUNCTION IF EXISTS fn_is_menu_present;

DELIMITER $$

CREATE FUNCTION fn_is_menu_present(in_name VARCHAR(20))
RETURNS BOOLEAN
    
    BEGIN
	RETURN EXISTS(SELECT 1 FROM menu WHERE NAME=in_name);
    END$$

DELIMITER;

SELECT fn_is_menu_present('pongal');

