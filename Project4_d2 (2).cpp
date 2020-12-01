  
#include<iostream>
#include<fstream>
#include<string>
#include<iomanip>

using namespace std;

//Global variables:
bool verboseMode = false;
const string myDelimiter = "|";
const int MaxFields = 20;



//Function prototype:
void supportedcommands();
void inputFile(string iFileName, ifstream& input);
void outputFile(string oFileName, ofstream& output);
void quitProgram();
int splitLineToArr(string inputText, string inputDelimiter, string outputFieldArr[], int maxFields);
int processDataFile(ifstream& inputfile, ofstream& outputfile, string delimiter);


int main()
{
	ifstream myinputFile;
	ofstream myoutputFile;
	string iFilename, oFilename;
	string command;

	supportedcommands();

	do {

		cout << "Enter a command from the list:  ";
		getline(cin, command);

		// we used if statements because we the commands are in a string data type. therefore we cannot use switch statement.
		if (command == "")
		{
			//skip 
		}

		else if (command == "CI")
		{
			myinputFile.close();
		}
		else  if (command == "CO")
		{
			myoutputFile.close();
		}

		else if (command == "h" || command == "H")
		{
			supportedcommands();
		}
		else if (command == "i" || command == "I")
		{
			inputFile(iFilename, myinputFile);
		}
		else if (command == "o" || command == "O")
		{
			outputFile(iFilename, myoutputFile);
		}

		else if (command == "p" || command == "P")
		{
			processDataFile(myinputFile, myoutputFile, myDelimiter);
		}

		else if (command == "q" || command == "Q")
		{
			quitProgram();
		}
		else
		{
			cout << "invalid Command. try agian!" << endl;
		}
		cout << "\t=======================================" << endl;

	} while (command != "q" || command != "Q");

	return 0;
}

//Help List
void supportedcommands()
{
	cout << "\tSupported commands :" << endl;
	cout << "\t--------------------" << endl;
	cout << "CI: Close input file.\n"
		<< "CO: Close output file.\n"
		<< "h: print this help text.\n"
		<< "i: open file for input.\n"
		<< "o: open file for output.\n"
		<< "p: (lower case 'p') process data file.\n"
		<< "q: quit(end the program).\n";
}

// to get the input file name and open it.
void inputFile(string iFileName, ifstream& input)
{
	cout << "enter the input file name: ";
	getline(cin, iFileName);
	input.open(iFileName);
}
//test

// to get the outputfile name and open it.

void outputFile(string oFileName, ofstream& output)
{

	cout << "enter the output file name: ";
	getline(cin, oFileName);
	output.open(oFileName);
}
// to Quit the program
void quitProgram()
{
	cout << "Exiting the program" << endl;
	system("pause");
	exit(0);
}

// to split the input line to fields and store them into an array
int splitLineToArr(string inputText, string inputDelimiter, string outputFieldArr[], int maxFields)
{
	//	Local Variables:
	int nextFieldPosition = 0;		//	Start position of data field.
	int foundPosition;				//  Position where delimiter was found,
	int fieldCount = 0;		        //  Number of data fields found so far,
	bool endOfLine = false;	//	Flag -- end of input line detected,
	//bool endOfField = false;
	string dataField;				//  Copy of the data field.
	


	
	if (verboseMode) {
		cout << "     Enter 'splitLineToArray' function, " << endl
			<< "     inputText = (" << inputText << ")" << endl
			<< "     nextFieldPosition = " << nextFieldPosition
			<< endl;
	}
	while (!endOfLine)
	{
		//"find function" takes 2 parameters, the first is the character we look for, and 
		//the 2nd is what's the position of that character.
		
		foundPosition = inputText.find(inputDelimiter, nextFieldPosition);
		
		
		if (foundPosition == -1)
		{
			// (Here if the string 'find' function reached the end of the input string.)
			endOfLine = true;
			if (verboseMode) {
				cout << "     delimiter not found for inputText = " << inputText << endl
					<< "          (search began at position " << nextFieldPosition << ")."
					<< endl;
			}
			foundPosition = inputText.length();

			if (foundPosition > nextFieldPosition)
			{

				//substr method takes 2 parameters, 1st is where i start and 2nd is how many char i need.
				dataField = inputText.substr(nextFieldPosition, (foundPosition - nextFieldPosition));
				if (verboseMode) {
					cout << " dataField = " << dataField << endl;
				}
				fieldCount++;
			}
		}
		else
		{
			// (Here if 'inputDelim' was found in the input string.)
			// Copy the data field contents from the input string to the
			// 'dataField' local variable.
			dataField = inputText.substr(nextFieldPosition, foundPosition - nextFieldPosition);
			fieldCount++;
			
		}
			// Adjust 'nextFieldPosition' as preparation for finding NEXT delimiter.
			nextFieldPosition = foundPosition + 1;
			
			if (verboseMode) 
			{
				cout << "     dataField = " << dataField << ", nextFieldPosition = "
					<< nextFieldPosition << endl;
			}

		if (fieldCount > 0)
		{
			if (fieldCount > maxFields)
			{
				cout << "ERROR at line __LINE__: too many input fields, fieldCount="
					<< fieldCount << endl;
			}
			else
			{
				outputFieldArr[fieldCount - 1] = dataField;
			}
		}
	} // (end while)

		
	if (verboseMode) {
		//	Before returning to the caller, display the 
		//    found data fields, as a debug aid:
		for (int i = 0; i < fieldCount; i++)
		{
			cout << "     outputFieldArray[" << i << "] = " << outputFieldArr[i] << endl;
		} // (end for)	
	}


	return fieldCount;
} // (end function splitLineToArray )

//
int processDataFile(ifstream& inputfile, ofstream& outputfile, string delimiter)
{
	//local variable

	int lineCount = 0;
	int fieldCount = 0;
	string inputTextLine;
	string textArray[MaxFields];
	int fdposition;
	const char quote = '"';
	const char comma = ',';
	int position = 0;
	int detecter=0;
	bool closeQuote = false;

	while (getline(inputfile, inputTextLine)) {
		fieldCount = splitLineToArr(inputTextLine, delimiter, textArray, MaxFields);
		lineCount++;
		
		// the for loop used to add quotes whereever the compiler finds a quate.
		//this for loop checks at every single field.

		for (int i = 0; i < fieldCount; i++)
		{
			do {
				fdposition = textArray[i].find(quote, position);
				if (fdposition >= position)
				{
					textArray[i].insert((fdposition + 1), 1, quote);
					closeQuote = true;

				}
				 detecter = position;
				position = fdposition+2;

			} while ((fdposition+2)>detecter);
			//initialize to 0 again:
			position = 0;
			fdposition = 0;
			// we used boolean to check if the the compiler found a quote or not. if so it encloses the field we Quotes.
			if (closeQuote == true) {
				textArray[i] = "\"" + textArray[i] + "\"";
			}
			closeQuote = false;
		}



		/////////////////////////////////////////////////////////////////////////


		// this loop to add Quote if we detect a comma.
		for (int i = 0; i < fieldCount; i++)
		{
			do {
				fdposition = textArray[i].find(comma, position);
				if (fdposition >= position)
				{
					closeQuote = true;
				}
				detecter = position;
				position = fdposition + 1;

			} while ((fdposition +1) > detecter);
			//initialize to 0 again:
			position = 0;
			fdposition = 0;
			// we used boolean to check if the the compiler found a quote or not. if so it encloses the field we Quotes.
			if (closeQuote == true) {
				textArray[i] = "\"" + textArray[i] + "\"";
			}
			closeQuote = false;
		
		}
		
		cout << "Input Data= " << inputTextLine << endl;
		cout << endl;

		//the for loop used to store the data into an outputFile. and it adds a comma after a field.
		for (int i = 0; i < fieldCount; i++) {
			outputfile << textArray[i] << ", ";
			if (i == (fieldCount - 1))
				outputfile << endl;
		}

	}
	// to count the lines.
	cout << lineCount << " lines of text read from input file." << endl;
	return lineCount;
}





