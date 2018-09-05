# Player.py
#
# Container to hold our player objects

class Player:

    # Player attributes

    id = 0
    first = None
    last = None
    position = None

    # Function used to create a player object

    def create(self, id, first, last, position):
        self.id = id
        self.first = first
        self.last = last
        self.position = position

