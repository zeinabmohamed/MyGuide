//
//  Settings.h
//  MyGuide
//
//  Created by squixy on 20.02.2014.
//  Copyright (c) 2014 BLStream - Rafał Korżyński. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <MapKit/MapKit.h>

@interface Settings : NSObject

@property (nonatomic, readonly) NSInteger innerRadius;
@property (nonatomic, readonly) NSInteger externalRadius;
@property (nonatomic, readonly) NSInteger centerRadius;
@property (nonatomic, readonly) NSInteger visitedRadius;

@property (nonatomic, readonly) NSString *languageFallback;

@property (nonatomic, readonly) BOOL showAnimalsOnMap;
@property (nonatomic, readonly) BOOL showUserPosition;
@property (nonatomic, readonly) BOOL showPathsOnMap;
@property (nonatomic, readonly) BOOL showJunctionsOnMap;
@property (nonatomic, readonly) BOOL showDebugRadiiOnMap;

@property (nonatomic, readonly) double cameraMaxAltitude;
@property (nonatomic, readonly) double cameraMinAltitude;
@property (atomic,    readonly) double maxUserDistance;

@property (nonatomic, readonly, getter = calculateZooCenter) CLLocationCoordinate2D zooCenter;
@property (nonatomic, readonly, getter = calculateMapCenter) CLLocationCoordinate2D mapCenter;
@property (nonatomic, readonly, getter = calculateMaxSpan)   MKCoordinateSpan       maxSpan;
@property (nonatomic, readonly, getter = calculateMinSpan)   MKCoordinateSpan       minSpan;
@property (nonatomic, readonly, getter = calculateMapBounds) MKCoordinateRegion     mapBounds;

@property (atomic) BOOL showDistanceAlert;

- (MKCoordinateSpan)        calculateMaxSpan;
- (MKCoordinateSpan)        calculateMinSpan;
- (MKCoordinateRegion)      calculateMapBounds;
- (CLLocationCoordinate2D)  calculateMapCenter;
- (CLLocationCoordinate2D)  calculateZooCenter;
- (void)injectDataWithName: (NSString*)name andValue:(NSString*)value;

+ (id)sharedSettingsData;

@end