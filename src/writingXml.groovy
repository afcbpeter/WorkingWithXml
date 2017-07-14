def file = new File('../../../documents/St_Louis_Zoo_sample.gpx')
def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

def markupBuilder = new groovy.xml.StreamingMarkupBuilder()
def xml = markupBuilder.bind {
    zoo {
        mkp.comment(gpx.metadata)
        gpx.wpt.each { point ->
            waypoint(timestamp: point.time.toString) {
                latitude(point.@lat)
                longitude(point.@lon)
            }
        }
    }
}

def outFile = new File('../../../documents/zoo_truncated.xml')
outFile.write(xml.toString())