package com.martins.first.Api;

public record UserObj(String login,
                int id,
                String avatar_url,
                String name,
                String Location,
                String email,
                String bio,
                String twitter_username) {
};
