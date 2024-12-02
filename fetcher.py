import requests

genre = input()
params = {
        "method": "tag.gettoptracks",
        "tag": genre,
        "api_key": "2b3020f4b0dfac666c95d4a11393729c",
        "format": "json",
        "limit": 100
    }
response = requests.get("http://ws.audioscrobbler.com/2.0/", params=params)
if response.status_code == 200:
    data = response.json()
    if "tracks" in data and "track" in data["tracks"]:
        top_songs = [f"{track['name']} - {track['artist']['name']}" for track in data["tracks"]["track"]]
        final = ""
        for elm in top_songs:
            final += (elm + " ; ")
        print(final)
    else:
        print("error")
else:
    print("error")

