USE LottoDB;
CREATE TABLE users (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE lottery_winners (
  id INT PRIMARY KEY,
  user_id INT,
  lottery_winner_id INT,
  winnings INT,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE lotteries (
  id INT PRIMARY KEY,
  lottery_name VARCHAR(255),
  start_date DATE,
  end_date DATE,
  winning_numbers VARCHAR(255)
);