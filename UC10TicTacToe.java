board = [
    ['X', 'O', 'X'],
    ['O', 'X', 'O'],
    ['O', 'X', 'O']
]

def is_draw():
    for row in range(3):
        for col in range(3):
            if board[row][col] == "": 
                return False
    return True


print("Is Draw:", is_draw())