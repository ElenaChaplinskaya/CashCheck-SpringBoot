INSERT
INTO
  public.product
  (id, name, price, discount)
VALUES
  (1, 'item1', 10.00, FALSE),
  (2, 'item2', 12.00, TRUE),
  (3, 'item3', 32.00, FALSE),
  (4, 'item4', 14.00, TRUE),
  (5, 'item5', 20.00, FALSE),
  (6, 'item6', 6.00, FALSE),
  (7, 'item7', 15.00, TRUE);

INSERT
INTO
  public.discount_card
  (id, number, discount)
VALUES
  (1, 'card-111', 3),
  (2, 'card-222', 5),
  (3, 'card-333', 7);
