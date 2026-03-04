extends Node

func tcp_client():
	var client = StreamPeerTCP.new()
	client.connect_to_host("127.0.0.1", 8080)
	
	if client.get_status() == StreamPeerTCP.STATUS_CONNECTED:
		client.put_utf8_string("Hello")


func udp_example():
	var udp = PacketPeerUDP.new()
	udp.bind(1234)
	udp.set_dest_address("127.0.0.1", 1234)
	udp.put_packet("Hi".to_utf8_buffer())
