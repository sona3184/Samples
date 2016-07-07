import random

def createDobletEvent(dobletId):
    #Temperature range: 25 - 35 deg C
    #Voltage range: 2 - 4.5 volts
    #Current range: -2 to +3 amps
    #Resistance range: 20 - 100 milliOhms
    temp = random.randrange(25, 35, 1)
    volt = round(random.uniform(2, 4.5), 2)
    curr = round(random.uniform(-2, 3), 2)
    resi = random.randrange(20, 100, 10)

    print dobletId + "," + str(temp) + "," + str(volt) + "," + str(curr) + "," + str(resi) + "\n"
    return

try:
    while True:
        createDobletEvent("12345678")
except KeyboardInterrupt:
    pass
