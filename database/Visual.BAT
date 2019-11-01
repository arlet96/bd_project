@echo Visual de la BD Curvas Elipticas
cd C:\MySQL\MySQL Server 5.5\bin
mysql -h localhost -u root -papa< C:\Users\Arlet\Documents\NetBeansProjects\bd_project\database\bdcurves.sql
mysql -h localhost -u root -papa< C:\Users\Arlet\Documents\NetBeansProjects\bd_project\database\crearcurvas.sql
:: IF YOU ELIMINATE THE COMMENTS OF THE NEXT LINE< IT WILL OPEN THE VISUAL PROGRAM
::cd C:\Users\Arlet\Documents\NetBeansProjects\bd_project\database
START C:\Users\Arlet\Documents\NetBeansProjects\bd_project\dist\bd_project.jar
exit

