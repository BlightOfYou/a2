DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(80) DEFAULT NULL,
  `salt` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `cultureboxes` DISABLE KEYS */;

INSERT INTO `users` VALUES (0,'christine', 'rbazkX6lKUBiFG+jyCQ9k8ttydN/tjcjbV1mOW4NEjo=' , '0F3il7taqYyRsHi4EDdxFgJP/2wwZxQstK+BBGuXLlM=');
INSERT INTO `users` VALUES (0,'daniel', '2KK+4QG5DVzXNWTJBvEMNIASnUryaN8YacNgeLmU64I=' , 'efWDTCU6/lt/C/CFKQmzRP/4F10XiWXJl5bkmLfsI6Q=');
INSERT INTO `users` VALUES (0,'keith', '4Ty4cskrndx4uL/6nZYyJLgzxltM/qT5OwOuuGmDN4o=' , 'dvCFujAUkMjT1zMlrNX4LaJLr1hezCVOOrmLQwkZOoo=');
INSERT INTO `users` VALUES (0,'micah', 'dyD6Vs/OT87qGD87tHdosprzCtLCjzVlc/mPgsnaTAY=' , '7fBQkhsZ8akPRs2v/TMrFotZfqUCj7ztyfJsGdVWSXs=');

/*!40000 ALTER TABLE `cultureboxes` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_log` (
  `log_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `session_id` bigint unsigned NOT NULL,
  `login` bigint DEFAULT NULL,
  `logout` bigint DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;