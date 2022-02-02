# Server makefile
TARGET	= $(COMP_TARGET)
APOBJS	= $(TARGET).o
LIBS	= -laps -lpcre  -lwbiconv -lwsadmin -lwbexpat -luuid
OBJS	= $(APOBJS) $(SDLOBJ) $(SVCTOBJ)
SVCTOBJ	= $(TARGET)_svctab.o
CFLAGS	= -O -I$(WEBTOBDIR) 
APPDIR	= $(WEBTOBDIR)/ap/upload
SVCTDIR	= $(WEBTOBDIR)/svct
LIBDIR	= $(WEBTOBDIR)/lib
.SUFFIXES : .c
.c.o:
	$(CC) $(CFLAGS) -c $<
$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -L$(LIBDIR) -o $(TARGET) $(OBJS)  $(LIBS)
	cp $(TARGET) $(SVCTDIR)
	rm -f $(OBJS)
$(APOBJS): $(TARGET).c
	$(CC) $(CFLAGS) -c $(TARGET).c
$(SVCTOBJ):
	$(CC) $(CFLAGS) -c $(SVCTDIR)/$(TARGET)_svctab.c
clean:
	-rm -f *.o core $(TARGET)
