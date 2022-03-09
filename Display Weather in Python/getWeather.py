import requests

# use the api to gather weather data
api_key = "43fc43185a71ff86f48257f1ac7bc55e"
f = open('output.txt', 'w')
# enter infinite loop until "EXIT" is entered
while 1:
    print("Enter 'EXIT' to end program!")
    location = input("Enter the city name: ")
    if location != 'EXIT':
        # creates api link and fetches data
        link = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + api_key
        api_link = requests.get(link)
        api_data = api_link.json()
        # translates data into readable form
        temp_city = ((api_data['main']['temp']) - 273.15)
        weather_description = api_data['weather'][0]['description']
        humidity = api_data['main']['humidity']
        wind_speed = api_data['wind']['speed']
        # writes data to a file named "output.txt"
        line = ('Location: ' + location)
        s = str(line)
        f.write(s+'\n')
        line = ("Current temperature is: " + str(temp_city) + " deg C")
        s = str(line)
        f.write(s+'\n')
        line = ("Current weather description: " + weather_description)
        s = str(line)
        f.write(s+'\n')
        line = ("Current humidity: " + str(humidity) + '%')
        s = str(line)
        f.write(s+'\n')
        line = ("Current wind speed: " + str(wind_speed) + ' kmph')
        s = str(line)
        f.write(s+'\n')
        f.write('\n')
        # prints data to the console
        print("Location: ", location)
        print("Current temperature is: ", temp_city, "  deg C")
        print("Current weather description  :", weather_description)
        print("Current humidity      :", humidity, '%')
        print("Current wind speed    :", wind_speed, 'kmph')
    else:
        break
# closes the file to complete the writing process
f.close()
