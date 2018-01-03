
CXXFLAGS:=-std=c++17

SRCS:=$(wildcard *.cc)
OBJS:=$(SRCS:.cc=.o)
APPS:=$(SRCS:%.cc=%)


#$(info $(SRCS) $(OBJS) $(APPS))

all : $(APPS)

% : %.o
	@$(CXX) -o $@ $^


.PHONY : clean

clean :
	@rm -f $(OBJS) $(APPS)
