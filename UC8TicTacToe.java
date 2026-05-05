# Tic-Tac-Toe Game

board = ['1','2','3',
         '4','5','6',
         '7','8','9']

game_over = False
is_player_x = True  # True = X, False = O


# Display board
def display_board():
    print()
    for i in range(0, 9, 3):
        print(f" {board[i]} | {board[i+1]} | {board[i+2]} ")
        if i < 6:
            print("---|---|---")
    print()


# Check win
def check_win():
    win_conditions = [
        [0,1,2], [3,4,5], [6,7,8],  # rows
        [0,3,6], [1,4,7], [2,5,8],  # columns
        [0,4,8], [2,4,6]            # diagonals
    ]
    
    for condition in win_conditions:
        a, b, c = condition
        if board[a] == board[b] == board[c]:
            return True
    return False


# Check draw
def check_draw():
    for cell in board:
        if cell not in ['X', 'O']:
            return False
    return True


# Make move
def make_move():
    global is_player_x
    mark = 'X' if is_player_x else 'O'

    try:
        choice = int(input(f"Player {mark}, enter position (1-9): "))
        if choice < 1 or choice > 9:
            print("Invalid position! Choose 1-9.")
            make_move()
            return

        if board[choice - 1] not in ['X', 'O']:
            board[choice - 1] = mark
        else:
            print("Cell already taken! Try again.")
            make_move()

    except ValueError:
        print("Invalid input! Enter a number.")
        make_move()


# Main game loop
print("=== Tic-Tac-Toe ===")

while not game_over:
    display_board()
    make_move()

    if check_win():
        display_board()
        print(f"Player {'X' if is_player_x else 'O'} wins!")
        game_over = True

    elif check_draw():
        display_board()
        print("It's a draw!")
        game_over = True

    else:
        # Switch turn
        is_player_x = not is_player_x