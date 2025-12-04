UPDATE usuario
SET email = REPLACE(email, '@daskill.com', '@dataskill.com')
WHERE email LIKE '%@daskill.com';
