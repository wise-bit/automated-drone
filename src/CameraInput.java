public class CameraInput {

    public CameraInput() {

        /*

        self.socket_video = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # socket for receiving video stream

        self.local_video_port = 11111  # port for receiving video stream

        # to receive video -- send cmd: command, streamon
        self.socket.sendto(b'command', self.tello_address)
        print ('sent: command')
        self.socket.sendto(b'streamon', self.tello_address)
        print ('sent: streamon')

        self.socket_video.bind((local_ip, self.local_video_port))

        # thread for receiving video
        self.receive_video_thread = threading.Thread(target=self._receive_video_thread)
        self.receive_video_thread.daemon = True

        self.receive_video_thread.start()


        def video_freeze(self, is_freeze=True):
                """Pause video output -- set is_freeze to True"""
                self.is_freeze = is_freeze
                if is_freeze:
                    self.last_frame = self.frame



        def _receive_video_thread(self):
            """
            Listens for video streaming (raw h264) from the Tello.
            Runs as a thread, sets self.frame to the most recent frame Tello captured.
            """
            packet_data = ""
            while True:
                try:
                    res_string, ip = self.socket_video.recvfrom(2048)
                    packet_data += res_string
                    # end of frame
                    if len(res_string) != 1460:
                        for frame in self._h264_decode(packet_data):
                            self.frame = frame
                        packet_data = ""

                except socket.error as exc:
                    print ("Caught exception socket.error : %s" % exc)

             */

    }

}
