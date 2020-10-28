INSERT INTO phone_type (description) VALUES
  ('Residencial'),
  ('Comercial'),
  ('Celular');
  
  INSERT INTO role (description) VALUES
  ('Administrador'),
  ('Usuário');

  
INSERT INTO `user` (`password`, `username`, `role_id`) VALUES ('$2a$10$nZ6PpvqN6INaaI9QUaikdOyCJAkz1LXWXpzG6qGxwvXuhYM64Rsy6', 'admin', '1');
  
INSERT INTO `user` (`password`, `username`, `role_id`) VALUES ('$2a$10$nZ6PpvqN6INaaI9QUaikdOyCJAkz1LXWXpzG6qGxwvXuhYM64Rsy6', 'comum', '2');
  
  