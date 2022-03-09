#include <fstream>
#include <iostream>
#include <string>

using namespace std;

class Song {

private:
	string line;
	string parse;

public:

	//method to find song reccomendations

	void songFinder(string &fileName, string &genre) {
		cout << "Music Reccomendations: " << endl;
		
		//opens specified .txt file 
		ifstream fileReader;
		fileReader.open(fileName+".txt");
		if (fileReader.is_open()) {
			while (!fileReader.eof()) {
				fileReader >> line;
				parse = line;

				//finds corresponding entries based on specified genre
				if (parse.substr(0, parse.find(':'))==genre) {
					cout << line <<endl;
				}
			}
		}
		fileReader.close();
	}

};
int main()
{
	Song s;
	string file;
	string genre;

	cout << "Please enter the file name: " << endl;
	getline(cin, file);
	cout << "Please enter a genre: " << endl;
	getline(cin, genre);
	cout << file << endl;
	cout << genre << endl;

	s.songFinder(file,genre);
}
