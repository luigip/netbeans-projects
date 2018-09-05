# HockeyRoster.py
#
# Implementation logic for the HockeyRoster application

#Import Player class from the Player module
from Player import Player

# Define as list to hold each of the Player objects
playerList = []

# makeSelection()
#
# Creates a selector for our application.  The function prints output to the
# command line.  It then takes a parameter as keyboard input at the command line
# in order to choose our application option.


def makeSelection():
    validOptions = ['1', '2', '3', '4']
    print "Please choose an option\n"


    selection = raw_input("Press 1 to add a player, 2 to print the team roster, 3 to search for a player on the team, 4 to quit: ")
    if selection not in validOptions:
        print "Not a valid option, please try again\n"
        makeSelection()
    else:
        if selection == '1':
            addPlayer()
        elif selection == '2':
            printRoster()
        elif selection == '3':
            searchRoster()
        else:
            print "Thanks for using the HockeyRoster application."

# addPlayer()
#
# Accepts keyboard input to add a player object to the roster list.  This function
# creates a new player object each time it is invoked and appends it to the list.
def addPlayer():
    addNew = 'Y'
    print "Add a player to the roster by providing the following information\n"
    while addNew.upper() == 'Y':
        first = raw_input("First Name: ")
        last = raw_input("Last Name: ")
        position = raw_input("Position: ")
        id = len(playerList)
        player = Player()
        player.create(id, first, last, position)
        playerList.append(player)
        print "Player successfully added to the team roster\n"
        addNew = raw_input("Add another? (Y or N)")
    makeSelection()

# printRoster()
#
# Prints the contents of the list to the command line as a report
def printRoster():
    print "====================\n"
    print "Complete Team Roster\n"
    print "======================\n\n"
    for player in playerList:
        print "%s %s - %s" % (player.first, player.last, player.position)
    print "\n"
    print "=== End of Roster ===\n"
    makeSelection()

# searchRoster()
#
# Takes input from the command line for a player's name to search within the
# roster list.  If the player is found in the list then an affirmative message
# is printed.  If not found, then a negative message is printed.
def searchRoster():
    index = 0
    found = False
    print "Enter a player name below to search the team\n"
    first = raw_input("First Name: ")
    last = raw_input("Last Name: ")
    position = None
    while index < len(playerList):
        player = playerList[index]
        if player.first.upper() == first.upper() or player.last.upper() == last.upper():
            found = True
            position = player.position
        index = index + 1
    if found:
        print '%s %s is in the roster as %s' % (first, last, position)
    else:
        print '%s %s is not in the roster.' % (first, last)
    makeSelection()

# main
#
# This is the application entry point.  It simply prints the applicaion title
# to the command line and then invokes the makeSelection() function.


if __name__ == "__main__":
    print "Hockey Roster Application\n\n"
    makeSelection()