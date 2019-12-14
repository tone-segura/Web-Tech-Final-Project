-- here is all our generated source tables
-- you can find the seed data we used for the user_attributes table in weka_data.csv file
create table site_user_info
(
    user_id    mediumint auto_increment
        primary key,
    username   char not null,
    first_name char not null,
    last_name  char not null,
    email      char not null,
    password   char not null
);

create table survey_results
(
    survey_id        mediumint auto_increment
        primary key,
    username_value   text null,
    accuracy_value   text null,
    return_value     text null,
    recommend_value  text null,
    improve_value    text null,
    functional_value text null
);

create table user_accounts
(
    username   varchar(255) null,
    password   text         null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    email      varchar(255) null,
    constraint email
        unique (email),
    constraint username
        unique (username)
);

create table user_attributes
(
    user_id                       bigint null,
    num_tweets                    int    null,
    retweet_ratio                 float  null,
    hashtag_ratio                 float  null,
    quote_ratio                   float  null,
    tweet_favorite_ratio          float  null,
    tweet_retweet_ratio           float  null,
    mention_ratio                 float  null,
    friend_follower_ratio         float  null,
    url_ratio                     float  null,
    listed_count                  int    null,
    verified                      text   null,
    geo_enabled                   text   null,
    profile_uses_background_image text   null,
    favourites_count              int    null,
    tweet_frequency_variance      text   null,
    class                         text   null
);

