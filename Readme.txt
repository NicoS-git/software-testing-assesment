The following instructions will guide you on how to set up the automated script

1)create a new maven project called automationsolution using an IDE of your choice.
2)add the dependencies for the following:

		-Selenium java
		-TestNG
		-Apache poi
		-relevantcodes
		-commons io

These dependencies can be found in the maven repository by clicking on this url: https://mvnrepository.com/ then typing each of the above in the seach bar and clicking search. the version does not matter

3) Once your dependencies are added proceed to navigate to src->test->java and create a package called feature and another one called utls.
4) In the feature package create a class called CheckOut
5 In the utls package create the following 3 classes

		-BaseTest
		-Excelutls
		-Mtds
6) In the Mtds class create a function for opening the browser called Launch
7) In the Excelutls class write the code which will enable selenium to read data from an excel sheet
8) In the Basetest class write the code for generating a report, logging the result of the test, capturing a screenshot and closing the report. You should specify the location where the report and screenshot should be stored as well as the name of the report.
9) In the CheckOut class use the @test annotation to specify the method CheckOutTest which will include the code for the actual test. Add Dataprovide = Customer in brackets next to the @test annotation to specify that this method will use data from a data provider using a method named Customer. 
10) in the CheckOutTest method inside the brackets add the following parameters:String username, String paasword, String sItem1, String sItem2. Call the Launch function from the Mtds class to open the browser. proceed to write the code for the end to end process of adding Items to your cart and specify where the data from the excel sheet should be populated
11) Create a excel spreadsheet and populate it in the following way:

		-Row 1 will conatin the values in the respective columns A1=Testname, B1=Username, C1=Password, D1=Item1, C1=Item2
		-Row 2 will contain the data for the corresponding values which selenium will read.
12) Save the excel Spearsheet as Testdata in a location of your choice.
13) In the Checkout class add another method called Customer which will specify the path of the data provider, the name of the sheet and the number of columns it needs to read from starting the count from 0.
