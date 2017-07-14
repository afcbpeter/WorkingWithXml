def file = new File('../../../documents/St_Louis_Zoo_sample.gpx')
println file.exists()

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)
println gpx.name()
println''
println gpx.metadata
println''
println gpx.@version
println gpx.@creator

gpx.wpt.each {
    println it.@lat
    println it.@lon
    println it.name
}