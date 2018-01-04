
CXXFLAGS:=-std=c++17 -pthread

SRCS:=$(wildcard *.cc)
APPS:=$(SRCS:%.cc=%)


#$(info $(SRCS) $(OBJS) $(APPS))

all : $(APPS)

% : %.o
	@$(CXX) $(LDFLAGS) -o $@ $^

.PHONY : clean 

clean :
	@rm -f $(APPS)
