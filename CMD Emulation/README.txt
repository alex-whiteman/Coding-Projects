This is a Command Prompt emulation. 

This program, once compiled and ran on your machine,
accepts the following inputs:

______________________________________________________________________________________
Command:               Description:
cd                     prints the current working directiory
cd (filepath)          changed the working directory to that of the filepath
cd ..                  changed the working directory to the parent working directory
dir                    prints all the files within the specified directory
history                displays all previously entered commands
!!                     re-runs the previously entered command(to function correctly,
                       the previously entered command must be a function of cmd.exe.
exit                   exits the program.
______________________________________________________________________________________

After recieving one of the above inputs, the program will output (if necessary) any 
information recieved from the buffered reader.

Note: the cd .. function will not display the working directory after it has
completed. To see the directory after this function call, simply use the cd command.
(the above statement also applies to the !! function in some instances)

Sincerely,
Alex Whiteman