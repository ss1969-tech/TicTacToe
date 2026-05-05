import tkinter as tk


root = tk.Tk()
root.title("Tic-Tac-Toe")


board = [""] * 9
current_player = "X"
buttons = []



def has_won(symbol):
    win_patterns = [
        [0,1,2], [3,4,5], [6,7,8],  # rows
        [0,3,6], [1,4,7], [2,5,8],  # columns
        [0,4,8], [2,4,6]            # diagonals
    ]
    
    for pattern in win_patterns:
        if all(board[i] == symbol for i in pattern):
            return True
    return False



def on_click(index):
    global current_player

    if board[index] == "":
        board[index] = current_player
        buttons[index]["text"] = current_player

        if has_won(current_player):
            status_label.config(text=f"Player {current_player} Wins!")
            disable_buttons()
            return

        if "" not in board:
            status_label.config(text="It's a Draw!")
            return

        current_player = "O" if current_player == "X" else "X"
        status_label.config(text=f"Player {current_player}'s Turn")



def disable_buttons():
    for btn in buttons:
        btn.config(state="disabled")


for i in range(9):
    btn = tk.Button(root, text="", font=("Arial", 24),
                    width=5, height=2,
                    command=lambda i=i: on_click(i))
    btn.grid(row=i//3, column=i%3)
    buttons.append(btn)

status_label = tk.Label(root, text="Player X's Turn", font=("Arial", 14))
status_label.grid(row=3, column=0, columnspan=3)

root.mainloop()