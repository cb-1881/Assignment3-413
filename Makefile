JAVAC=javac
JAVA=java
CLASSPATH=dep/*:classes
SRC_DIR=src
BUILD_DIR=classes

all: clean compile run

clean:
	@echo "Cleaning..."
	@rm -rf $(BUILD_DIR)/*.class

compile:
	@echo "Compiling..."
	@$(JAVAC) -cp "$(CLASSPATH)" -d $(BUILD_DIR) $(SRC_DIR)/*.java

run:
	@echo "Everythings ready, Please run make driver"
   

driver:
	@echo "running driver for GUI"
	@$(JAVA) -cp "dep/*:classes" Driver
	
createDatabase:
	@echo "creating database..."
	@$(JAVA) -cp "dep/*:classes" databaseSetup

dropTables:
	@echo "Dropping tables..."
	@$(JAVA) -cp "dep/*:classes" dropTables

populateDatabase:
	@echo "Running..."
	@$(JAVA) -cp "dep/*:classes" ExampleTest

.PHONY: all clean compile run dropTables
