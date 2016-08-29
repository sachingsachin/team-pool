CREATE database teamwork;
use teamwork;

CREATE TABLE teamwork.Users (
    user_id VARCHAR(40),
    fname VARCHAR(64),
    lname VARCHAR(64),
    id1  VARCHAR(64),
    id2  VARCHAR(64),
    id3  VARCHAR(64),
    id4  VARCHAR(64),
	-- Picture
    reports_to VARCHAR(64),
    status VARCHAR(256),
    PRIMARY KEY (user_id),
    FOREIGN KEY (reports_to) REFERENCES Users(user_id)
);

CREATE TABLE teamwork.Products (
    product_id VARCHAR(40),
    name VARCHAR(128),
    started DATE,
    brief_description VARCHAR(512),
    product_email VARCHAR(128),
    slack_channel VARCHAR(128),
    jira_link VARCHAR(128),
    -- Open-source components (link to other product-detail pages)
    detailed_docs_url VARCHAR(128),
    github_repos VARCHAR(512),
    quick_start_example_links VARCHAR(512),
    -- Prominent users of this product / skill
    -- Features needed (with votings from users, show users only when more than 5)
    -- Job well done (with votings from users, show users only when more than 5)
    PRIMARY KEY (product_id)
);

CREATE TABLE teamwork.Teams (
    team_id VARCHAR(40),
    name VARCHAR(128),
    started DATE,
    brief_description VARCHAR(512),
    team_homepage VARCHAR(128),
    PRIMARY KEY (team_id)
);

CREATE TABLE teamwork.User_Product_Mapping (
    User_Product_Mapping_Id VARCHAR(40),
    user_id VARCHAR(40),
    product_id VARCHAR(40),
    role VARCHAR(64),
    PRIMARY KEY (User_Product_Mapping_Id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    UNIQUE (user_id, product_id)
);

CREATE TABLE teamwork.Product_Team_Mapping (
    Product_Team_Mapping_Id VARCHAR(40),
    product_id VARCHAR(40),
    team_id VARCHAR(40),
    PRIMARY KEY (Product_Team_Mapping_Id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (team_id) REFERENCES Teams(team_id),
    UNIQUE (product_id, team_id)
);
