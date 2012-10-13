# Add Post

# --- !Ups
CREATE TABLE Post (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `menu` int(11) DEFAULT NULL,
  `postedDate` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (author_id) REFERENCES Author(id)
);
# --- !Downs
DROP TABLE Post;